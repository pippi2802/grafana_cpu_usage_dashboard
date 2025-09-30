# Grafana Dashboard for CPU Usage – JetBrains Internship Task

**Author:** Silvia Brighi

This repository contains my solution for the JetBrains internship task *“Monitoring as Code for YouTrack”*.

The approach I took is **Observability as Code**:
- The Grafana dashboard is programmatically defined in **Java** using the **Grafana Foundation SDK**.
- The dashboard definition is exported as JSON and can be imported directly into Grafana.

## Repository Structure

- `src/main/java/` – Java code that builds the dashboard programmatically.
- `generated_dashboard/` – Generated JSON dashboard file.
- `docker-compose.yaml` – Demo environment with **Grafana**, **Prometheus**, **Loki**, and **Alertmanager** for testing.
- `testdata/` – Example k6 scripts for generating synthetic metrics and logs.

## Technologies Used

- **Java JDK 21** (tested on 21.0.8)
- **Maven 3.9.11** for build automation
- **Grafana Foundation SDK** for dashboard as code
- **Grafana** for visualization
- **Prometheus** as the metrics backend
- **Loki** for log aggregation
- **Alertmanager** for alerting
- **k6 + xk6 extensions** to generate test metrics and logs

## Running the Project

### 1. Build the project
```bash
mvn clean package
```
### 2. Run the Java code
Execute the Main class located in `src/main/java/org/example`.
This will generate the JSON representation of the dashboard in `generated_dashboard/`.

### 3. Strat demo environment
```bash
docker compose up -d
```
This will spin up:
- Grafana → http://localhost:3000
- Prometheus → http://localhost:9090
- Alertmanager → http://localhost:9093
- Loki → http://localhost:3100

### 5. Import the Dashboard
1. Open Grafana at http://localhost:3000
2. Go to Dashboards → Import
3. Upload the JSON file from `generated_dashboard/`

