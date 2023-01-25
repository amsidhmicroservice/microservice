### pull all ms-service
docker pull docker.io/amsidhmicroservice/ms-card-service
docker pull docker.io/amsidhmicroservice/ms-account-service
docker pull docker.io/amsidhmicroservice/ms-location-service
docker pull docker.io/amsidhmicroservice/ms-address-service
docker pull docker.io/amsidhmicroservice/ms-person-service

### Now deploy all service helm charts
helm upgrade --install ms-card-release ms-card-service-chart
helm upgrade --install ms-account-release ms-account-service-chart
helm upgrade --install ms-location-release ms-location-service-chart
helm upgrade --install ms-address-release ms-address-service-chart
helm upgrade --install ms-person-release ms-person-service-chart
