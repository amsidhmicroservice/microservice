# MicroServices Project

# Get Kubernetes Resource version supported.
  kubectl api-resources





####
Change postgres to H2 database as it requires more effort to create database prior to deploy the service.
Removed zookeeper as gke itself discover service by service name.
Added ingress gateway to expose single public ip and route the rquest to specific service based on the rule configured



Following command wait for pod to become ready.
kubectl wait --namespace ingress-nginx --for=condition=ready pod --selector=app.kubernetes.io/component=controller --timeout=120s

https://kubernetes.github.io/ingress-nginx/deploy/#docker-for-mac



### For kubectl not able to pull images from know repository then please do the following steps:

1. Uncheck >Docker Desktop-> Resource-> WSL Integration
   ![docker.png](docker.png)
