# Pharmacy Tracking Prototype

A small classroom prototype for batch inventory, expiry alerts, and prescription stock checks using fictional demonstration data.

## Run

Requires Java 17 and Maven.

From the project folder:

    mvn compile
    mvn exec:java

Open http://localhost:7070/ in a browser. The current page confirms that the Java web application starts; inventory features will be added in separate steps.

## Current scope

The current foundation contains the core data classes: Medicine, Batch, PrescriptionRequest, and StockCheckResult. It does not yet save records or implement inventory operations, expiry alerts, or stock-check calculations.
