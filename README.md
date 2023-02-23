# Logging and metrics in Rancher

## Install Logging via Rancher UI
[Enabling Logging](https://ranchermanager.docs.rancher.com/pages-for-subheaders/logging#enabling-logging)

## Install monitoring via Rancher UI
[Install the Monitoring Application](https://ranchermanager.docs.rancher.com/how-to-guides/advanced-user-guides/monitoring-alerting-guides/enable-monitoring#install-the-monitoring-application)

## Loki deployen
    helm repo add grafana https://grafana.github.io/helm-charts
    helm repo add loki https://grafana.github.io/loki/charts
    helm repo update
    helm upgrade --install loki loki/loki

## Demo App in Docker Registry deployen
    mvnw package

## Deploy to Kubernetes
    cat kube/*.yaml | kubectl apply -f