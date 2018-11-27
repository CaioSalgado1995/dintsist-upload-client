package br.com.utfpr.dis.upload.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.utfpr.dis.services.IProcessamento;

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
	public ModelAndView upload(MultipartFile arquivo) {
		
		try {
			List<Double> sinais = converteArquivo(arquivo, 10);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		iProcessamento.processaImagem(new int[]{1,2});
		
		return new ModelAndView("redirect:upload");
	}
	
	private List<Double> converteArquivo(MultipartFile arquivo, int ganho) throws IOException {
		List<Double> sinais = new ArrayList<Double>();
		
		System.out.println("Iniciando conversão do arquivo para um ArrayList");
		
		InputStream stream = arquivo.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		
		String linha = reader.readLine();
		
		while(linha != null) {
			
			Double valorSinal = Double.parseDouble(linha);
			
			sinais.add(valorSinal);
			
			linha = reader.readLine();
		}
		
		reader.close();
		stream.close();
		
		System.out.println("Finalizando conversão do arquivo para um ArrayList");
		System.out.println("Tamanho do arquivo == " + sinais.size());
		
		return sinais;
	}
}
