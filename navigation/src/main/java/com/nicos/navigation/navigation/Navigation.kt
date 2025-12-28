@file:OptIn(ExperimentalMaterial3AdaptiveApi::class)

package com.nicos.navigation.navigation

import androidx.activity.SystemBarStyle
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.navigation3.ListDetailSceneStrategy
import androidx.compose.material3.adaptive.navigation3.rememberListDetailSceneStrategy
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.LocalNavAnimatedContentScope
import androidx.navigation3.ui.NavDisplay
import com.nicos.compose_ui.pokemon_details_screen.PokemonDetailsScreen
import com.nicos.compose_ui.pokemon_list_screen.PokemonListScreen
import com.nicos.compose_ui.utils.extensions.decodeStringUrl
import com.nicos.compose_ui.utils.extensions.encodeStringUrl
import com.nicos.navigation.navigation.navigation_3.Navigator
import com.nicos.navigation.navigation.navigation_3.navigationState
import com.nicos.navigation.navigation.screen_routes.PokemonDetails
import com.nicos.navigation.navigation.screen_routes.PokemonList

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun Navigation(changeSystemBarStyle: (SystemBarStyle) -> Unit) {

    // Navigation 3
    val navigationState = PokemonList.navigationState()
    val navigator = remember { Navigator(navigationState) }

    // Navigation Scene Strategy
    val listDetailStrategy = rememberListDetailSceneStrategy<NavKey>()

    SharedTransitionLayout {
        NavDisplay(
            backStack = navigationState.stacksInUse,
            onBack = {
                navigator.goBack()
            },
            sceneStrategy = listDetailStrategy,
            entryProvider = entryProvider {
                entry<PokemonList>(
                    metadata = ListDetailSceneStrategy.listPane()
                ) {
                    PokemonListScreen(
                        animatedVisibilityScope = LocalNavAnimatedContentScope.current,
                        listener = {
                            navigator.navigate(
                                PokemonDetails(
                                    url = it.url?.encodeStringUrl() ?: "",
                                    imageUrl = it.imageUrl?.encodeStringUrl() ?: "",
                                    name = it.name,
                                )
                            )
                        }
                    )
                }

                entry<PokemonDetails>(
                    metadata = ListDetailSceneStrategy.detailPane()
                ) {
                    PokemonDetailsScreen(
                        url = it.url.decodeStringUrl(),
                        imageUrl = it.imageUrl.decodeStringUrl(),
                        name = it.name,
                        changeSystemBarStyle = changeSystemBarStyle,
                        animatedVisibilityScope = LocalNavAnimatedContentScope.current,
                        backButton = {
                            navigator.goBack()
                        }
                    )
                }
            }
        )
    }
}
