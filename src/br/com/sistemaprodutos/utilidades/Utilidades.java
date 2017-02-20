package br.com.sistemaprodutos.utilidades;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

import org.apache.struts.upload.FormFile;

import br.com.aghata.EasyWorkingReport.exceptions.ReportException;
import br.com.sistemaprodutos.exceptions.DadosInvalidosException;
import br.com.sistemaprodutos.exceptions.RelatorioException;

public abstract class Utilidades {

	/**
	 * Expressão regular utilizada para analizar um valor que contenha apenas
	 * espaço em branco, independente do tamanho da string
	 */
	private static Pattern expressaoAvaliaValorEmBranco = Pattern.compile("[ ]+");

	public static Date parseDate(String data, String mascara)
			throws ParseException {
		if (data != null && !"".equals(data)) {
			SimpleDateFormat dateFormat = new SimpleDateFormat();

			if (mascara != null && !"".equals(mascara) && data.length() > 10) {
				dateFormat.applyPattern(mascara);
			} else {
				dateFormat.applyPattern("dd/MM/yyyy");
			}

			dateFormat.setLenient(false);
			return dateFormat.parse(data);
		}

		return null;
	}

	public static String parseDate(Date data, String mascara)
			throws ParseException {
		if (data != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat();

			if (mascara != null && !"".equals(mascara)) {
				dateFormat.applyPattern(mascara);
			} else {
				dateFormat.applyPattern("dd/MM/yyyy");
			}

			dateFormat.setLenient(false);
			return dateFormat.format(data); // <-- O format é o que difere do
											// outro método.
		}

		return null;
	}

	@SuppressWarnings("rawtypes")
	public static boolean isListaVazia(Object valor) {
		try {
			if (valor instanceof Collection) {
				Collection lista = (Collection) valor;
				if (lista.size() == 0) {
					return true;
				}
			} else if (valor instanceof HashMap) {
				HashMap lista = (HashMap) valor;
				if (lista.size() == 0) {
					return true;
				}
			}
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	public static boolean isValorEmBranco(Object valor) {
		try {
			return expressaoAvaliaValorEmBranco.matcher(valor.toString())
					.matches();
		} catch (NullPointerException e) {
			return false;
		}
	}

	public static boolean isNuloOuVazio(Object valor) {
		return valor == null || isValorEmBranco(valor) || "".equals(valor)
				|| isListaVazia(valor);
	}

	public static Object parseValue(Object valor, Class tipoRetorno)
			throws DadosInvalidosException {
		if (!isNuloOuVazio(valor)) {

			if (Integer.class.getName().equals(tipoRetorno.getName())) {

				try {
					return new Integer(valor.toString());
				} catch (Exception e) {
					throw new DadosInvalidosException(
							new IllegalArgumentException());
				}

			} else if (Date.class.getName().equals(tipoRetorno.getName())) {

				try {
					return parseDate(valor.toString(), null);
				} catch (Exception e) {
					throw new DadosInvalidosException(
							new IllegalArgumentException());
				}

			} else if (Boolean.class.getName().equals(tipoRetorno.getName())) {

				try {
					return new Boolean(valor.toString());
				} catch (Exception e) {
					throw new DadosInvalidosException(
							new IllegalArgumentException());
				}

			} else if (Byte.class.getName().equals(tipoRetorno.getName())) {

				try {
					return new Byte(valor.toString());
				} catch (Exception e) {
					throw new DadosInvalidosException(
							new IllegalArgumentException());
				}

			} else if (BigDecimal.class.getName().equals(tipoRetorno.getName())) {

				try {
					return new BigDecimal(valor.toString());
				} catch (Exception e) {
					throw new DadosInvalidosException(
							new IllegalArgumentException());
				}

			} else if (Short.class.getName().equals(tipoRetorno.getName())) {

				try {
					return new Short(valor.toString());
				} catch (Exception e) {
					throw new DadosInvalidosException(
							new IllegalArgumentException());
				}

			} else if (Long.class.getName().equals(tipoRetorno.getName())) {

				try {
					return new Long(valor.toString());
				} catch (Exception e) {
					throw new DadosInvalidosException(
							new IllegalArgumentException());
				}

			} else if (String.class.getName().equals(tipoRetorno.getName())) {
				// IF usado no getDTO
				try {
					if (valor instanceof Date) {
						return parseDate((Date) valor, "dd/MM/yyyy");
					}
					return valor.toString();
				} catch (Exception e) {
					throw new DadosInvalidosException(
							new IllegalArgumentException());
				}

			} else {
				throw new DadosInvalidosException(new IllegalArgumentException(
						"Tipo de dado não tratado!"
								+ tipoRetorno.getClass().getName() + ")"));
			}
		}
		return null;
	}

	/**
	 * Método responável por processar codigos html. Este método pega o
	 * relatorio que esta vindo como byte[] e o escreve no response da pagina.
	 * 
	 * @param response
	 * @param conteudo
	 * @return boolean - Sucesso no processo ou não.
	 * @throws IOException
	 * @throws ReportException
	 */
	public static boolean writeHtmlToResponse(ServletResponse response,
			byte[] conteudo) throws IOException, RelatorioException {
		ServletOutputStream out = null;
		try {
			response.setContentType("application/pdf");
			response.setContentLength(conteudo.length);

			out = response.getOutputStream();
			out.write(conteudo);
			out.flush();
			response.flushBuffer();

			return true;
		} catch (Exception ex) {
			System.out.println("Error flushing the Response: " + ex.toString());
			throw new RelatorioException("Problema ao gerar o relatório", ex);
		} finally {
			// out.close();
		}
	}
	
	public static final File upload( FormFile myFormFile, String filePath ) throws Exception {

		  // ============= UPLOAD ============= \\
		  // Process the FormFile
		  FormFile myFile = myFormFile;

		  // Get the file name
		  String fileName = myFile.getFileName();

		  File file = null;

		  if ( !fileName.equals( "" ) ) {
		   // ====== INICIO EXECUTAR UPLOAD ====== \\
		   // Get the servers upload directory real path name   
		   file = executarUpload( filePath, myFile.getContentType(), myFile.getFileData(), fileName );
		   // ====== FIM EXECUTAR UPLOAD ====== \\    
		  }
		  return file;
		 }
		 
		 public static final File executarUpload( String path, String contentType, byte[ ] arquivo, String nomeImagem ) throws Exception {

		  String fileName = nomeImagem;
		  
		  // Get the servers upload directory real path name
		  String filePath = path;
		  File fileToCreate = null;

		  /* Save file on the server */
		  if ( !fileName.equals( "" ) ) {
		   System.out.println( "Server path:" + filePath );

		   File f = new File( filePath );
		   if ( !f.exists() ) {
		    f.mkdirs();
		   }

		   // Create file
		   fileToCreate = new File( filePath, fileName );
		   // If file does not exists create file
		   //if ( !fileToCreate.exists()) {// Comentado por Gabriel a fim de o redimencionamento funcionar. Pois é feito o upload e depois um Reupload com a imagem redimencionada.
			FileOutputStream fileOutStream = new FileOutputStream( fileToCreate );
		   fileOutStream.write( arquivo );
		   fileOutStream.flush();
		   fileOutStream.close();
		   //}   
		  }
		  return fileToCreate;
		 }

}