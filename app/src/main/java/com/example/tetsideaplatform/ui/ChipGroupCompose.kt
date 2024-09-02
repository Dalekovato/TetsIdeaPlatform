package com.example.tetsideaplatform.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tetsideaplatform.ui.theme.PurpleGrey40
import com.example.tetsideaplatform.ui.theme.PurpleGrey80

@Composable
fun ChipGroupCompose(){

    val chipList: List<String> = listOf(
        "Spent",
        "Add",
        "Saving"
    )

    val selected by remember {
        mutableStateOf("")
    }
    Row (
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ){
        chipList.forEach{
            Chip(title = it, selected = selected) {

            }
        }
    }

}

@Composable
fun Chip(
    title: String,
    selected: String,
    onSelected:()-> Unit,
){
    val isSelected = selected == title
    val background = if(isSelected) Color.Blue else PurpleGrey40 //TODO
    val contentColor = if(isSelected) Color.White else Color.Black

    Box(
        modifier = Modifier
            .padding(end = 5.dp )
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(30)
            )
            .height(35.dp)
            .clip(CircleShape)
            //.background(background)
            .clickable(
                onClick = {
                    onSelected()
                }
            )
    ){
        Row(
            modifier = Modifier.padding(9.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            AnimatedVisibility(visible = isSelected) {

            }

            Text(text = title , color = contentColor, fontSize = 16.sp)

        }
    }
}