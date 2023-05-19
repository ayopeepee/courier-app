package com.example.delivery.data

import com.example.delivery.model.*

object Datasource {

    val orders: List<Order> = listOf(
        Order(
            Company("ABC Corporation", "456 Elm St, Suite 202"),
            SmallPackage(fragility = true),
            "123 Main St",
            "456 Elm St",
            2500,
            false
        ),
        Order(
            Company("XYZ Enterprises", "789 Oak St, Suite 500"),
            BigPackage(fragility = false, isCarNeeded = true, weight = 50),
            "456 Elm St",
            "789 Oak St",
            7500,
            false
        ),
        Order(
            Company("Acme Corporation", "1111 Maple Ave, Floor 2"),
            DocumentPackage(fragility = false, sender = "123 Main St", recipient = "456 Broad St"),
            "123 Main St",
            "456 Broad St",
            2599,
            false
        ),
        Order(
            Company("Smith & Co", "456 Oak Rd"),
            DocumentPackage(fragility = true, sender = "456 Oak Rd", recipient = "789 Pine St"),
            "456 Oak Rd",
            "789 Pine St",
            399,
            false
        ),
        Order(
            Company("Global Enterprises", "1111 First St"),
            BigPackage(fragility = false, isCarNeeded = true, weight = 100),
            "1111 First St",
            "2222 Second Ave",
            3599,
            false
        ),
        Order(
            Company("Johnson Industries", "333 Third St"),
            SmallPackage(fragility = true),
            "333 Third St",
            "444 Fourth Ave",
            999,
            false
        ),
        Order(
            Company("Aboba", "228 Avenue"),
            DocumentPackage(fragility = false, sender = "Pushkina 1", recipient = "77 Second St"),
            "Pushkina 1",
            "77 Second St",
            667,
            false
        )
    )
}