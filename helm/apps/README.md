### pull all ms-service
docker pull docker.io/amsidhmicroservice/ms-card-service:0.0.2-SNAPSHOT
docker pull docker.io/amsidhmicroservice/ms-account-service:0.0.2-SNAPSHOT
docker pull docker.io/amsidhmicroservice/ms-location-service:0.0.2-SNAPSHOT
docker pull docker.io/amsidhmicroservice/ms-address-service:0.0.2-SNAPSHOT
docker pull docker.io/amsidhmicroservice/ms-person-service:0.0.2-SNAPSHOT


### Now deploy all service helm charts
helm upgrade --install ms-card-release ms-card-service-chart
helm upgrade --install ms-account-release ms-account-service-chart
helm upgrade --install ms-location-release ms-location-service-chart
helm upgrade --install ms-address-release ms-address-service-chart
helm upgrade --install ms-person-release ms-person-service-chart

### Uninstall all ms
helm uninstall ms-card-release
helm uninstall ms-account-release
helm uninstall ms-location-release
helm uninstall ms-address-release
helm uninstall ms-person-release


