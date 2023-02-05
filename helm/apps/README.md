### pull all ms-service
docker pull docker.io/amsidhmicroservice/ms-card-service:0.0.1-mysql
docker pull docker.io/amsidhmicroservice/ms-account-service:0.0.1-mysql
docker pull docker.io/amsidhmicroservice/ms-location-service:0.0.1-mysql
docker pull docker.io/amsidhmicroservice/ms-address-service:0.0.1-mysql
docker pull docker.io/amsidhmicroservice/ms-person-service:0.0.1-mysql


### Now deploy all service helm charts
helm upgrade --install ms-card-release ms-card-service-chart --namespace apps --create-namespace
helm upgrade --install ms-account-release ms-account-service-chart --namespace apps --create-namespace
helm upgrade --install ms-location-release ms-location-service-chart --namespace apps --create-namespace
helm upgrade --install ms-address-release ms-address-service-chart --namespace apps --create-namespace
helm upgrade --install ms-person-release ms-person-service-chart --namespace apps --create-namespace

### Uninstall all ms
helm uninstall ms-card-release -n apps
helm uninstall ms-account-release -n apps
helm uninstall ms-location-release -n apps
helm uninstall ms-address-release -n apps
helm uninstall ms-person-release -n apps



