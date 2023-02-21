# Logging und Metriken im Rancher

## Logging über Rancher UI installieren
[Enabling Logging](https://ranchermanager.docs.rancher.com/pages-for-subheaders/logging#enabling-logging)

## Monitoring über Rancher UI installieren
[Install the Monitoring Application](https://ranchermanager.docs.rancher.com/how-to-guides/advanced-user-guides/monitoring-alerting-guides/enable-monitoring#install-the-monitoring-application)

## Loki deployen
    helm repo add grafana https://grafana.github.io/helm-charts
    helm repo add loki https://grafana.github.io/loki/charts
    helm repo update
    helm upgrade --install loki loki/loki

## Demo App in Docker Registry deployen
    mvnw package

## Nach Kubernetes deployen
    cat kube/*.yaml | kubectl apply -f