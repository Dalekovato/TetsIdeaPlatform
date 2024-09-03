package com.example.tetsideaplatform.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import com.example.tetsideaplatform.domain.model.ItemDomain
import com.example.tetsideaplatform.ui.theme.Orange10
import com.example.tetsideaplatform.ui.theme.Purple10
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun ItemList() {

    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(7.dp),
        elevation = CardDefaults.cardElevation(0.dp),
        shape = RoundedCornerShape(10.dp)
    ){

        Column (modifier = Modifier.padding(7.dp)){
            Row (modifier = Modifier.fillMaxWidth()){

                Text(
                    text = "iPhone 13",
                    fontSize = 20.sp,
                    modifier = Modifier.fillMaxWidth()
                        .weight(1f)
                        .padding(10.dp)
                )

                IconButton(
                    onClick = {

                }) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit",tint = Purple10)
                }
                IconButton(
                    onClick = {

                    }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete", tint = Orange10)
                }
            }

            Row (modifier = Modifier.fillMaxWidth()){
                ChipGroupCompose()
            }

            Row(horizontalArrangement = Arrangement.Start) {

                Column(horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .weight(1f)
                        .padding(10.dp)
                ) {
                    Text(text = "На складе",Modifier.padding(3.dp))
                    Text(text = "12",Modifier.padding(3.dp))
                }

                Column(horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .weight(1f)
                        .padding(10.dp)
                ) {
                    Text(text = "Дата добавления",Modifier.padding(3.dp))
                    Text(text = "ДД.ММ.ГГГГ",Modifier.padding(3.dp))
                }

            }
        }

    }

}

fun formatDate(date: Long):String =
    SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(date)
