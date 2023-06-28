package com.main.weatherx.main.presentation.communication

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.main.weatherx.main.presentation.core.Mapper
import com.main.weatherx.main.presentation.core.SingleLiveEvent

interface Communication {

    interface Observe<T> {
        fun observe(owner: LifecycleOwner, observer: Observer<T>)
    }

    interface Value<T> {
        fun value(): T?
    }

    interface Mutate<T> : Mapper.Unit<T>

    interface Mutable<T> : Observe<T>, Mutate<T>, Value<T>

    abstract class Abstract<T>(
        protected val liveData: MutableLiveData<T> = MutableLiveData()
    ) : Mutable<T> {

        override fun observe(owner: LifecycleOwner, observer: Observer<T>) {
            liveData.observe(owner, observer)
        }

        override fun value(): T? {
            return liveData.value
        }
    }

    abstract class Ui<T>(
        liveData: MutableLiveData<T> = MutableLiveData()
    ) : Abstract<T>(liveData) {

        override fun map(source: T) {
            liveData.value = source
        }
    }

    abstract class Post<T>(
        liveData: MutableLiveData<T> = MutableLiveData()
    ) : Abstract<T>(liveData) {
        override fun map(source: T) = liveData.postValue(source)
    }

    abstract class SingleUi<T> : Ui<T>(SingleLiveEvent())
    abstract class SinglePost<T> : Post<T>(SingleLiveEvent())
}
