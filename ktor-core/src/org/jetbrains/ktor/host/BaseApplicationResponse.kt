package org.jetbrains.ktor.host

import org.jetbrains.ktor.application.*
import org.jetbrains.ktor.http.*
import org.jetbrains.ktor.response.*

abstract class BaseApplicationResponse(call: ApplicationCall, private val responsePipeline: RespondPipeline) : ApplicationResponse {
    private var _status: HttpStatusCode? = null
    override val pipeline: RespondPipeline
        get() = responsePipeline

    override val cookies = ResponseCookies(this, call.request)

    override fun status() = _status
    override fun status(value: HttpStatusCode) {
        _status = value
        setStatus(value)
    }

    protected abstract fun setStatus(statusCode: HttpStatusCode)
}