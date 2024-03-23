package com.example.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero
import com.example.superheroes.ui.theme.SuperHeroesTheme

@Composable
private fun HeroItem(hero: Hero, modifier: Modifier = Modifier) {
    Card(elevation = CardDefaults.cardElevation(dimensionResource(id = R.dimen.small)), modifier = modifier) {
       Row(modifier = Modifier
           .padding(dimensionResource(id = R.dimen.medium))
           .fillMaxWidth()
       ) {
           HeroInfo(hero, modifier = Modifier.weight(2f, false))
           Spacer(
               modifier = Modifier
                   .width(dimensionResource(id = R.dimen.medium))
                   .weight(1f)
           )
           Box(
               modifier = Modifier.height(dimensionResource(id = R.dimen.large))
           ) {
               Image(
                   painter = painterResource(id = hero.imageResourceId),
                   contentDescription = stringResource(id = hero.descriptionId),
                   modifier = Modifier
                       .clip(MaterialTheme.shapes.small),
                   contentScale = ContentScale.Fit
               )
           }
       }
    }
}

@Composable
private fun HeroInfo(hero: Hero, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = hero.nameId),
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = stringResource(id = hero.descriptionId),
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}

@Composable
fun HeroList(heroesList: List<Hero>, modifier: Modifier = Modifier, contentPaddingValues: PaddingValues) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPaddingValues,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(heroesList) {hero ->
            HeroItem(hero = hero)
        }
    }
}



@Preview
@Composable
private fun HeroPreview() {
    SuperHeroesTheme(darkTheme = false) {
        HeroItem(hero = Hero(R.string.hero1, R.string.description1, R.drawable.android_superhero1))
    }
}

@Preview
@Composable
private fun HeroDarkThemePreview() {
    SuperHeroesTheme(darkTheme = true) {
        HeroItem(hero = Hero(R.string.hero1, R.string.description1, R.drawable.android_superhero1))
    }
}