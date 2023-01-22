### Run FluentD using bitnami fluentd helm chart
Come inside this folder and update the elasticsearch host and password then and enter the flow command.
helm upgrade --install fluentd-release bitnami/fluentd -f values.yaml