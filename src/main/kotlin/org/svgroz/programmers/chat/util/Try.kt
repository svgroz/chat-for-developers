package org.svgroz.programmers.chat.util

sealed class Try<V, E: Throwable>

class Success<V, E: Throwable>(val value: V): Try<V, E>()

class Error<V, E: Throwable>(val error: E): Try<V, E>()
