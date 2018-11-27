package br.com.utfpr.dis.upload.infra;

public class CallbackImpl implements ICallback{

	public void callbackProcessamento(String mensagem) {
		System.out.println(mensagem);
	}

}
