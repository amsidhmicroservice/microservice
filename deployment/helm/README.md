### helm create chartName
Go outside chartName
Print all files with loaded values on console
-> helm template chartName
sanitary command lint provided by helm which you could run to identify possible issues forehand.
-> helm lint chartName

Use the following -dry-run command to verify your Spring Boot Helm Chart
-> helm install ms-card-service --debug --dry-run ms-card-service
Run the helm now use following command
-> helm install ms-card-service-helm ms-card-service
Update helm chart if there are any changes made to values file

helm upgrade <release name> <chart directory>
Ex.
helm upgrade ms-person-service-helm ms-person-service -f ms-person-service\values.yaml

