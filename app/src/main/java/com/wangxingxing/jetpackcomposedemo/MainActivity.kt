package com.wangxingxing.jetpackcomposedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Clip
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Image
import androidx.ui.graphics.ImageConfig
import androidx.ui.graphics.colorspace.ColorSpaces
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.themeTextStyle
import androidx.ui.material.withOpacity
import androidx.ui.res.imageResource
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
//                Greeting("Android")
                UILayout()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun UILayout() {
    // 获取图片
    val image = +imageResource(R.mipmap.header)
    // 使用Material Design 设计
    MaterialTheme() {
        Column (
            modifier = Spacing(16.dp)
        ){//  添加Column，使布局垂直排列
            // 放在容器中，设置大小
            Container(expanded = true, height = 180.dp) {
                Clip(shape = RoundedCornerShape(10.dp)) {
                    // 显示图片
                    DrawImage(image)
                }
            }

            HeightSpacer(height = 20.dp) // 添加垂直方向间距20dp

            Text("Jetpack Compose使用:写起来简单，复用性又强，可以抽取很多组件来复用，不用管理复杂的状态变更!",
                maxLines = 2, overflow = TextOverflow.Ellipsis,
                style = (+themeTextStyle { h5 }).withOpacity(0.87f)) // 注意添加了style

            Text("Android技术杂货铺", style = (+themeTextStyle { body1 }).withOpacity(0.87f))
            Text("Coolbear", style = (+themeTextStyle { body2 }).withOpacity(0.6f))
        }
    }

}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
//        Greeting("Android")
        UILayout()
    }
}
