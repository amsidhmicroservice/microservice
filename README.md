# MicroServices Project

# Get Kubernetes Resource version supported.
  kubectl api-resources





####
Change postgres to H2 database as it requires more effort to create database prior to deploy the service.
Removed zookeeper as gke itself discover service by service name.
Added ingress gateway to expose single public ip and route the rquest to specific service based on the rule configured
