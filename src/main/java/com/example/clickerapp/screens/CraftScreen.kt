package com.example.clickerapp.screens

import android.content.ClipData
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.draganddrop.dragAndDropSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draganddrop.DragAndDropTransferData
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clickerapp.data.Game

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun craftScreen() {
    var game = Game()
    Column {
        workbench(game)
        inventory(game)
    }
}

@Composable
fun workbench(game: Game) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
    Column {
        for (py in game.workbench.products){
            Row {
                for (px in py){
                    Box(
                        Modifier
                            .width(80.dp)
                            .height(80.dp)
                            .border(2.dp, Color.Black, RoundedCornerShape(10))
                    )
                }
            }
        }
    }
    Row(verticalAlignment = Alignment.CenterVertically){
        Icon(Icons.Default.PlayArrow, "",Modifier.size(50.dp))
        Box(
            Modifier
                .width(80.dp)
                .height(80.dp)
                .border(2.dp, Color.Black, RoundedCornerShape(10))
        )
    }
}}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun inventory(game: Game){
    Column {
        for (py in game.inventory.products){
            Row {
                for (px in py){
                    Box(
                        Modifier
                            .dragAndDropSource(
                                drawDragDecoration = {
                                    drawRect(Color.Red)
                                }
                            ){
                                startTransfer(
                                    DragAndDropTransferData(
                                        clipData = ClipData.newPlainText("ProductId", px.id.toString())
                                    ))
                            }
                            .width(80.dp)
                            .height(80.dp)
                            .border(2.dp, Color.Black, RoundedCornerShape(10))
                    )
                }
            }
        }
    }
}