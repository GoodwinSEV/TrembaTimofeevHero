package com.example.trembatimofeevhero
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.trembatimofeevhero.data.Hero
import com.example.trembatimofeevhero.data.heros
import com.example.trembatimofeevhero.ui.theme.TrembaTimofeevHeroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrembaTimofeevHeroTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    HeroApp()
                }
            }
        }
    }
}
val nameFontFamily = FontFamily(Font(R.font.quint, FontWeight.Normal)
)
val descriptionFontFamily = FontFamily(Font(R.font.special, FontWeight.Normal))
@Composable
fun HeroApp(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "Killers",
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = nameFontFamily
        )

        LazyColumn(modifier = modifier) {
            items(heros) {
                HeroItem(
                    hero = it,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
                )
            }
        }
    }
}


@Composable
fun HeroItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            HeroIcon(hero.imageResourceId)
            HeroInformation(hero.name, hero.description)
        }
    }
}

@Composable
fun HeroIcon(
    @DrawableRes heroIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_medium)),
        painter = painterResource(heroIcon),
        contentDescription = null
    )
}

@Composable
fun HeroInformation(
    @StringRes heroName: Int,
    @StringRes heroDescription: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(heroName),
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small)),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = nameFontFamily
        )
        Text(
            text = stringResource(heroDescription),
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small)),
            fontSize = 14.sp,
            lineHeight = 16.sp,
            fontFamily = descriptionFontFamily
        )
    }
}

@Preview
@Composable
fun TrembaTimofeevHeroPreview() {
    TrembaTimofeevHeroTheme(darkTheme = true) {
        HeroApp()
    }
}