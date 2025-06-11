// File: 01_CoreJava/12_ConcurrencyUtilities/03_CompletableFuture/CompletableFutureExample.java
package com.javahub.corejava.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Demonstrates the use of CompletableFuture for asynchronous programming.
 * CompletableFuture allows you to write non-blocking code and handle results
 * of asynchronous computations.
 */
public class CompletableFutureExample {

    /**
     * Simulates a long-running task that fetches user details asynchronously.
     * @param userId The ID of the user to fetch.
     * @return A CompletableFuture that will eventually hold the user's name.
     */
    public static CompletableFuture<String> fetchUserDetails(int userId) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching user " + userId + " details in " + Thread.currentThread().getName());
            try {
                // Simulate network delay
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
            if (userId == 1) {
                return "Alice";
            } else if (userId == 2) {
                return "Bob";
            } else {
                return "Unknown User";
            }
        });
    }

    /**
     * Simulates a long-running task that sends an email asynchronously.
     * @param recipient The recipient of the email.
     * @param message The email message.
     * @return A CompletableFuture that will eventually hold a confirmation message.
     */
    public static CompletableFuture<String> sendEmail(String recipient, String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Sending email to " + recipient + " in " + Thread.currentThread().getName());
            try {
                // Simulate email sending delay
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
            return "Email sent to " + recipient + ": '" + message + "'";
        });
    }

    public static void main(String[] args) {
        System.out.println("Application started in " + Thread.currentThread().getName());

        // Scenario 1: Independent asynchronous tasks
        CompletableFuture<String> userFuture1 = fetchUserDetails(1);
        CompletableFuture<String> emailFuture = sendEmail("support@example.com", "Welcome!");

        // Combine results of independent tasks
        userFuture1.thenAcceptBoth(emailFuture, (userName, emailStatus) -> {
            System.out.println(userName + " processed. Email status: " + emailStatus);
        });

        // Scenario 2: Chaining dependent asynchronous tasks
        CompletableFuture<String> combinedFuture = fetchUserDetails(2)
            .thenApplyAsync(userName -> {
                // This will run in a new thread from ForkJoinPool.commonPool()
                System.out.println("Processing user name " + userName + " in " + Thread.currentThread().getName());
                return "Processed: " + userName.toUpperCase();
            })
            .thenCompose(processedName -> {
                // This will run after the previous stage completes
                System.out.println("Composing with processed name " + processedName + " in " + Thread.currentThread().getName());
                return sendEmail(processedName.replace("Processed: ", "").toLowerCase() + "@company.com", "Your report is ready!");
            });

        // Block and get the final result (in real apps, you'd chain more non-blocking operations)
        try {
            String finalResult = combinedFuture.get(); // Blocks until all stages complete
            System.out.println("Final result of chained operations: " + finalResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("Application continuing its work (non-blocking aspects).");

        // Keep main thread alive briefly to allow async tasks to complete
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Application finished.");
    }
}
