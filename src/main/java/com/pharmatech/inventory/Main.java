package com.pharmatech.inventory;

import io.javalin.Javalin;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        Javalin.create(config ->
                config.routes.get("/", ctx -> ctx.html("""
                        <!doctype html>
                        <html lang="en">
                        <head>
                            <meta charset="UTF-8">
                            <meta name="viewport" content="width=device-width, initial-scale=1">
                            <title>Pharmacy Tracking Prototype</title>
                        </head>
                        <body>
                            <main>
                                <h1>Pharmacy Tracking Prototype</h1>
                                <p>Project foundation is running. Batch inventory will be added in the next step.</p>
                            </main>
                        </body>
                        </html>
                        """)))
            .start(7070);
    }
}
