package com.example.tetsideaplatform.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tetsideaplatform.ui.theme.Blue10

@Preview(showBackground = true)
@Composable
fun MainScreen(

) {


   Surface(
       modifier = Modifier.fillMaxSize(),
       color = Blue10
   ) {
       Column {

           Card(
               modifier = Modifier
                   .fillMaxWidth()
                   .size(100.dp),
               colors = CardDefaults.cardColors(Blue10),
               elevation = CardDefaults.cardElevation(0.dp),
               shape = RoundedCornerShape(0.dp),

               ) {
               Column(modifier = Modifier.padding(top = 70.dp)) {
                   Text(
                       text = "Список товаров",
                       modifier = Modifier.fillMaxWidth(),
                       fontSize = 20.sp,
                       textAlign = TextAlign.Center,
                   )
               }
           }

           Card(
               modifier = Modifier
                   .fillMaxSize()
                   ,
               colors = CardDefaults.cardColors(Color.LightGray),
               elevation = CardDefaults.cardElevation(0.dp),
               shape = RoundedCornerShape(0.dp),

               ) {
               Column(modifier = Modifier.fillMaxWidth()) {

                   SearchBar()

                   LazyColumn(
                       modifier = Modifier.fillMaxWidth()
                   ) {
                       items(6){
                           ItemList()
                       }
                   }

               }
           }

       }

   }

}


