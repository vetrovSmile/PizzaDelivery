package com.example.pizzadelivery.presentation.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzadelivery.domain.BannersItem
import com.example.pizzadelivery.domain.usecases.GetBannersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuFragmentViewModal @Inject constructor(
    private val getBannersUseCase: GetBannersUseCase
): ViewModel() {

    private val _getBanners = MutableStateFlow<List<BannersItem?>>(listOf(null))
    val getBanners: StateFlow<List<BannersItem?>> = _getBanners.asStateFlow()

    fun getBannerItem(){
        viewModelScope.launch {
            val banners = getBannersUseCase.invoke()
            _getBanners.value = banners
        }
    }

}