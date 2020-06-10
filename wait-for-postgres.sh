#!/bin/sh
# wait-for-postgres.sh

set -e

host="$1"
shift
cmd="$@"

until PGPASSWORD=$SPRING_DATASOURCE_PASSWORD PGUSER=$SPRING_DATASOURCE_USERNAME psql -h "$host" -U "$PGUSER" -c '\q'; do
  >&2 echo "Postgres is unavailable - sleeping"
  sleep 1
done

>&2 echo "Postgres is up - executing command"
exec $cmd
