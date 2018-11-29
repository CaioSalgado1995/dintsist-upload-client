package br.com.utfpr.dis.upload.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.utfpr.dis.services.IProcessamento;
import br.com.utfpr.dis.upload.model.Sinal;

@Controller
@RequestMapping("/upload")
public class UploadController {
	
	@Autowired
	private IProcessamento iProcessamento;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("upload/index");
	}
	
	@RequestMapping("/create")
	public ModelAndView create() {
		return new ModelAndView("upload/form");
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView upload(MultipartFile arquivo, @Valid Sinal sinal) {
		List<Double> sinais = new ArrayList<Double>();
		
		try {
			 sinais = converteArquivo(arquivo, sinal.getConstant());
		} catch (IOException e) {
			sinais = null;
		}
		
		if(sinais != null) {
			iProcessamento.processaImagem(sinais);
		}
		
		return new ModelAndView("redirect:upload");
	}
	
	/**
	 * Efetua leitura do arquivo .csv adicionando o ganho para cada linha
	 * @param arquivo arquivo de sinais
	 * @param ganho digitado pelo usuário
	 * @return um ArrayList contendo os sinais somados com o ganho
	 * @throws IOException em erro de leitura
	 */
	private List<Double> converteArquivo(MultipartFile arquivo, int ganho) throws IOException {
		List<Double> sinais = new ArrayList<Double>();
		InputStream stream = arquivo.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		
		// Le linha por linha
		String linha = reader.readLine();
		
		while(linha != null) {
			
			// Faz a conversão do falor String para Double
			Double valorSinal = Double.parseDouble(linha);
			
			// Faz a soma com o ganho digitado pelo usuário, nesse caso uma constante
			Double sinalComGanho = valorSinal + ganho;
			
			// adiciona o sinal ao ArrayList
			sinais.add(sinalComGanho);
			
			// continua lendo o arquivo
			linha = reader.readLine();
		}
		
		// Fechar os leitores
		reader.close();
		stream.close();
		
		return sinais;
	}
}
