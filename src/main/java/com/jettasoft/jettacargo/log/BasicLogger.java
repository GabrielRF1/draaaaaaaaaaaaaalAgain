

import java.sql.Timestamp;

public class BasicLogger {
	
	public static enum nivel{
		DESABILITADO,//NENHUM LOG
		ERRO,//APENAS LOG DE ERRO
		INFO,//APENAS LOG DE FUNCIONAMENTO
		DEBUG//TODOS OS LOG, INCLUIDO OS DE DEBUG
		
	}
	
	private static nivel nivelDeLog = nivel.DEBUG;
	
	private static boolean nivelValido(nivel nivelDeLog) {
		return BasicLogger.nivelDeLog.ordinal() >= nivelDeLog.ordinal();
	}
	
	public static void configuraNivel(nivel nivelDeLog) {
		BasicLogger.nivelDeLog = nivelDeLog;
	}
	
	public static void cabecalho(nivel nivelDeLog) {
		System.out.print(new Timestamp(System.currentTimeMillis()));
		System.out.print(" ["+nivelDeLog+"] : ");
	}
	
	public static void logDebug(String str) {
		if(!nivelValido(nivel.DEBUG)) return;
		
		cabecalho(nivel.DEBUG);
		System.out.println(str);
	}
	
	public static void logDebug(Object obj) {
		if(!nivelValido(nivel.DEBUG)) return;
		
		cabecalho(nivel.DEBUG);
		System.out.println(obj.toString());
	}
	
	public static void logInfo(String str) {
		if(!nivelValido(nivel.INFO)) return;
		
		cabecalho(nivel.INFO);
		System.out.println(str);
	}
	
	public static void logInfo(Object obj) {
		if(!nivelValido(nivel.INFO)) return;
		
		cabecalho(nivel.INFO);
		System.out.println(obj.toString());
	}
	
	public static void logErro(String str) {
		if(!nivelValido(nivel.ERRO)) return;
		
		cabecalho(nivel.ERRO);
		System.out.println(str);
	}
	
	public static void logErro(Object obj) {
		if(!nivelValido(nivel.ERRO)) return;
		
		cabecalho(nivel.ERRO);
		System.out.println(obj.toString());
	}
}
