# Pharmacy Stock Desk

A focused Java and Javalin prototype for recording medicine batches, spotting expiry dates, and checking prescription quantities against available unexpired stock.

## Scope

The prototype tracks medicine code and name, batch number, quantity, and expiry date. Expiry alerts include expired batches and batches inside a selected time window. Prescription stock checks compare requested quantities with recorded unexpired batches and report any shortfall.

A stock check is informational: it does not dispense medicine or reduce inventory. The prototype does not validate prescriptions clinically. Use fictional data for demonstrations. The local working copy currently contains fictional demo batches; a fresh clone starts with an empty inventory.

## Requirements

- Java 17 or later
- Apache Maven 3.9 or later

## Start the app

Open a terminal in the project folder and run:

```text
mvn clean compile
mvn exec:java
```

Then open [http://localhost:7070](http://localhost:7070). Stop the app with `Ctrl+C` in the terminal.

Batch records are saved to `data/batches.json` and remain after the app restarts. The `data` folder is local app data and is excluded from Git.

## Use the prototype

1. Select **Add batch**, enter the medicine details, batch number, quantity, and expiry date, then save.
2. Find batches in the inventory table. Use **Edit** to update a recorded batch.
3. Choose an expiry window to see expired and upcoming batches.
4. Enter a prescription reference, one or more medicine codes, and requested quantities. Select **Check availability** to see available unexpired quantities and any shortfall. The check does not change stock.

## API endpoints

- `GET /api/health` — check that the server is running
- `GET /api/batches` — list batches
- `GET /api/batches/{id}` — get a batch
- `POST /api/batches` — add a batch
- `PUT /api/batches/{id}` — update a batch
- `GET /api/alerts/expiry?withinDays=30` — get expiry alerts
- `POST /api/stock-checks` — compare prescription items with available stock

## Main classes and OOP concepts

- `Medicine` and `Batch` hold the inventory data. Their fields are private; `Batch` validates input before it is saved (**encapsulation**).
- `StockRepository` defines how batches are read and saved (**abstraction**).
- `FileStockRepository` saves JSON to disk. `InMemoryStockRepository` keeps data temporarily. Both implement `StockRepository`, and `StockService` works through that shared interface (**polymorphism**).
- `BatchNotFoundException` extends `RuntimeException` and is mapped to a clear HTTP 404 response (**inheritance** and exception handling).
- `StockService` contains the inventory, expiry, and stock-check rules. It uses Java lists and maps to handle batches and requested quantities (**collections**).

The in-memory repository can be selected for a temporary run with `mvn exec:java -Dexec.args=memory`; it will not preserve data after stopping.
