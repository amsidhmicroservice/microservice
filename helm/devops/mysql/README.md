If you want to untar the mysql bitnami image.
helm pull bitnami/mysql --untar
Now you can refer the values file from extracted folder and change the values in your values.yaml accordingly.

helm upgrade --install mysql bitnami/mysql --values values.yaml --namespace mysql --create-namespace --dry-run