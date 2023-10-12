package com.example.tummocandroidassignment.ui.utils

import com.example.tummocandroidassignment.R
import com.example.tummocandroidassignment.ui.domain.model.AboutItem
import com.example.tummocandroidassignment.ui.domain.model.CategoryItem
import com.example.tummocandroidassignment.ui.domain.model.ProductItem
import com.example.tummocandroidassignment.ui.theme.BackgroundCategory1
import com.example.tummocandroidassignment.ui.theme.BackgroundCategory2
import com.example.tummocandroidassignment.ui.theme.BackgroundCategory3
import com.example.tummocandroidassignment.ui.theme.BackgroundCategory4
import com.example.tummocandroidassignment.ui.theme.BackgroundCategory5
import com.example.tummocandroidassignment.ui.theme.BackgroundCategory6

object DataDummy {

    fun generateDummyProduct(): List<ProductItem> {
        return listOf(
            ProductItem(
                id = 5501,
                name = "Potato Chips",
                icon = "https://cdn-icons-png.flaticon.com/128/2553/2553691.png",
                unit = "1pcs, Price",
                price = 40.00,
                nutritions = "50gr",
                review = 3.5,
                categories = "Food",
            ),
            ProductItem(
                id = 5502,
                name = "Penne Pasta",
                icon = "https://cdn-icons-png.flaticon.com/128/2553/2553691.png",
                unit = "10pcs, Price",
                price = 110.40,
                nutritions = "150gr",
                review = 5.0,
                categories = "Food",
            ),
            ProductItem(
                id = 5503,
                name = "Tomato Ketchup",
                icon = "https://cdn-icons-png.flaticon.com/128/2553/2553691.png",
                unit = "1pcs, Price",
                price = 80.00,
                nutritions = "100gr",
                review = 4.0,
                categories = "Food",
            ),
            ProductItem(
                id = 5504,
                name = "Nutella Spread",
                icon = "https://cdn-icons-png.flaticon.com/128/2553/2553691.png",
                unit = "1pcs, Price",
                price = 120.00,
                nutritions = "90gr",
                review = 4.7,
                categories = "Food",
            ),
            ProductItem(
                id = 5505,
                name = "Everyday Granola",
                icon = "https://cdn-icons-png.flaticon.com/128/2553/2553691.png",
                unit = "20pcs, Price",
                price = 450.00,
                nutritions = "50gr",
                review = 4.2,
                categories = "Food",
            ),
            ProductItem(
                id = 5601,
                name = "Orange Fanta 1 Litre",
                icon = "https://cdn-icons-png.flaticon.com/128/2405/2405479.png",
                unit = "1pcs, Price",
                price = 100.5,
                nutritions = "10gr",
                review = 3.8,
                categories = "Beverages",
            ),
            ProductItem(
                id = 5602,
                name = "Keventers Thick Shake 60 ml",
                icon = "https://cdn-icons-png.flaticon.com/128/2405/2405479.png",
                unit = "1pcs, Price",
                price = 79.99,
                nutritions = "70gr",
                review = 3.0,
                categories = "Beverages",
            ),
            ProductItem(
                id = 5603,
                name = "Fresh Jaljeera",
                icon = "https://cdn-icons-png.flaticon.com/128/2405/2405479.png",
                unit = "1pcs, Price",
                price = 50.5,
                nutritions = "100gr",
                review = 4.2,
                categories = "Beverages",
            ),
            ProductItem(
                id = 5701,
                name = "Clear Baby Shampoo",
                icon = "https://cdn-icons-png.flaticon.com/128/2553/2553642.png",
                unit = "1pcs, Price",
                price = 300.54,
                nutritions = "",
                review = 4.7,
                categories = "Hygiene Essentials",
            ),
            ProductItem(
                id = 5702,
                name = "Walnut Scrub Daily Glow",
                icon = "https://cdn-icons-png.flaticon.com/128/2553/2553642.png",
                unit = "8pcs, Price",
                price = 165.10,
                nutritions = "",
                review = 4.5,
                categories = "Hygiene Essentials",
            ),
            ProductItem(
                id = 5703,
                name = "Shine Detergent Powder 1 kg",
                icon = "https://cdn-icons-png.flaticon.com/128/2553/2553642.png",
                unit = "1kg, Price",
                price = 300.10,
                nutritions = "",
                review = 4.5,
                categories = "Hygiene Essentials",
            ),ProductItem(
                id = 5704,
                name = "All-in-one Cleaner",
                icon = "https://cdn-icons-png.flaticon.com/128/2553/2553642.png",
                unit = "1pcs, Price",
                price = 90.10,
                nutritions = "",
                review = 4.5,
                categories = "Hygiene Essentials",
            ),ProductItem(
                id = 5705,
                name = "Soft Tissue Box",
                icon = "https://cdn-icons-png.flaticon.com/128/2553/2553642.png",
                unit = "8pcs, Price",
                price = 40.10,
                nutritions = "",
                review = 4.5,
                categories = "Hygiene Essentials",
            ),ProductItem(
                id = 5706,
                name = "Aroma Essence Balls 10 Pieces",
                icon = "https://cdn-icons-png.flaticon.com/128/2553/2553642.png",
                unit = "10pcs, Price",
                price = 200.10,
                nutritions = "",
                review = 4.5,
                categories = "Hygiene Essentials",
            ), ProductItem(
                id = 5801,
                name = "Camphor Large",
                icon = "https://cdn-icons-png.flaticon.com/128/7096/7096435.png",
                unit = "8pcs, Price",
                price = 165.10,
                nutritions = "",
                review = 4.5,
                categories = "Pooja Daily Needs",
            ), ProductItem(
                id = 5802,
                name = "Mix Fresh Flowers",
                icon = "https://cdn-icons-png.flaticon.com/128/7096/7096435.png",
                unit = "8pcs, Price",
                price = 80.10,
                nutritions = "",
                review = 4.5,
                categories = "Pooja Daily Needs",
            ), ProductItem(
                id = 5803,
                name = "Sandalwood Incense Sticks",
                icon = "https://cdn-icons-png.flaticon.com/128/7096/7096435.png",
                unit = "8pcs, Price",
                price = 90.10,
                nutritions = "",
                review = 4.5,
                categories = "Pooja Daily Needs",
            ), ProductItem(
                id = 5804,
                name = "Premium Candle Pack of 10",
                icon = "https://cdn-icons-png.flaticon.com/128/7096/7096435.png",
                unit = "10pcs, Price",
                price = 400.10,
                nutritions = "",
                review = 4.5,
                categories = "Pooja Daily Needs",
            ), ProductItem(
                id = 5901,
                name = "USB Cable Type C",
                icon = "https://cdn-icons-png.flaticon.com/128/3659/3659899.png",
                unit = "1pcs, Price",
                price = 200.10,
                nutritions = "",
                review = 4.5,
                categories = "Electronic Items",
            ), ProductItem(
                id = 5902,
                name = "HearSense Bluetooth Speaker",
                icon = "https://cdn-icons-png.flaticon.com/128/3659/3659899.png",
                unit = "1pcs, Price",
                price = 3500.10,
                nutritions = "",
                review = 4.5,
                categories = "Electronic Items",
            ), ProductItem(
                id = 5903,
                name = "Smartwatch Black NewGen",
                icon = "https://cdn-icons-png.flaticon.com/128/3659/3659899.png",
                unit = "1pcs, Price",
                price = 6500.10,
                nutritions = "",
                review = 4.5,
                categories = "Electronic Items",
            )
        )
    }

    fun generateDummyCategories(): List<CategoryItem> {
        return listOf(
            CategoryItem(
                title = "Food",
                image = "https://cdn-icons-png.flaticon.com/128/2553/2553691.png",
                background = BackgroundCategory1
            ),
            CategoryItem(
                title = "Beverages",
                image = "https://cdn-icons-png.flaticon.com/128/2405/2405479.png",
                background = BackgroundCategory2
            ),
            CategoryItem(
                title = "Hygiene Essentials",
                image = "https://cdn-icons-png.flaticon.com/128/2553/2553642.png",
                background = BackgroundCategory3
            ),
            CategoryItem(
                title = "Pooja Daily Needs",
                image = "https://cdn-icons-png.flaticon.com/128/7096/7096435.png",
                background = BackgroundCategory4
            ),
            CategoryItem(
                title = "Electronic Items",
                image = "https://cdn-icons-png.flaticon.com/128/3659/3659899.png",
                background = BackgroundCategory5
            ),
        )
    }

    fun generateDummyAbout(): List<AboutItem> {
        return listOf(
            AboutItem(
                image = R.drawable.ic_orders,
                title = "Orders"
            ),
            AboutItem(
                image = R.drawable.ic_my_details,
                title = "My Details"
            ),
            AboutItem(
                image = R.drawable.ic_address,
                title = "Delivery Address"
            ),
            AboutItem(
                image = R.drawable.ic_payment,
                title = "Payment"
            ),
            AboutItem(
                image = R.drawable.ic_notification,
                title = "Notification"
            ),
        )
    }

}