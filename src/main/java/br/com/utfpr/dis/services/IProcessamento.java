package br.com.utfpr.dis.services;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IProcessamento {

	int[] processaImagem(List<Double> ganho);
}
