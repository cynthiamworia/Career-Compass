package com.example.careercompass.ui.theme.screens.events

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.careercompass.R
import com.example.careercompass.data.ProductViewModel
import com.example.careercompass.ui.theme.CareerCompassTheme
import com.example.careercompass.ui.theme.models.Product
import com.example.careercompass.ui.theme.navigation.EVENTA_URL
import com.example.careercompass.ui.theme.navigation.EVENTV_URL
import com.example.careercompass.ui.theme.navigation.HOME_URL
import com.example.careercompass.ui.theme.navigation.ROUTE_INVITEA
import com.example.careercompass.ui.theme.screens.homepage.Gensans

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewEventsScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        CenterAlignedTopAppBar(
            title = { Text("VIEW EVENTS"
                , color = Color(0xF7F000FF),
                fontFamily = FontFamily.Cursive) },
            navigationIcon = {
                IconButton(onClick = { navController.navigate(HOME_URL) }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Profile")
                }
            },
            actions = {
                IconButton(onClick = { navController.navigate(EVENTA_URL) }) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "Chat")

                }
            }
        )

        var context = LocalContext.current
        var productRepository = ProductViewModel(navController, context)


        val emptyProductState = remember { mutableStateOf(Product("","","","","")) }
        var emptyProductsListState = remember { mutableStateListOf<Product>() }

        var products = productRepository.allProducts(emptyProductState, emptyProductsListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All Events",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(products){
                    ProductItem(
                        name = it.name,
                        quantity = it.quantity,
                        price = it.price,
                        id = it.id,
                        navController = navController,
                        productRepository = productRepository,
                        productImage = it.imageUrl
                    )
                }
            }
        }
    }
}


@Composable
fun ProductItem(name:String, quantity:String, price:String, id:String,
                navController:NavHostController,
                productRepository:ProductViewModel, productImage:String) {




    Column(modifier = Modifier.fillMaxWidth().background(color = Color(0xFFE22DFF))) {
        val MyCompositionLocal = compositionLocalOf { "Default value" }
        Text(text = "EVENT NAME:"+name)
        Text(text = "EVENT DATE:"+quantity)
        Text(text = "COST OF ATTENDANCE:"+price)

        Image(
            painter = rememberAsyncImagePainter(productImage),
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )
//        Button(onClick = {
//            productRepository.deleteProduct(id)
//        }) {
//            Text(text = "Delete")
//        }
//        Button(onClick = {
//            navController.navigate(EVENTA_URL+"/$id")
//        }) {
//            Text(text = "Update")
//        }
    }
}

@Composable
@Preview(showBackground = true)
fun ViewProductsScreenPreview(){
    CareerCompassTheme {
        ViewEventsScreen(navController = rememberNavController())
    }
}