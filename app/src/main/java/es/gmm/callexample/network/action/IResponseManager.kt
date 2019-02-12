package es.gmm.callexample.network.action

interface IResponseManager{

    fun initCall()
    fun endCall();
    fun onResponseCode(code: Int)


}