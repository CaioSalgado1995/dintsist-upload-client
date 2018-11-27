package br.com.utfpr.dis.services;

import org.springframework.stereotype.Service;

@Service
public interface IProcessamento {

	int[] processaImagem(int [] vetor);
}
