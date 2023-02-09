
/**
 * Clase que representa a los estudiantes de doctorado
 * @author puente
 *
 */
public class EDoctorado extends EPostGrado
{
	private ProgramaDoctorado programa;	
	private static final double MINTAX = 200;
	private static final double MAXTAX = 500;

	/**
	 * Constructor de EDoctorado por componentes, recibe los valores iniciales tanto para los atributos propios como los heredados
	 * Se verifica que las tasas estén dentro de los límites antes de enviarlas al constructor de la superclase
	 * @param nombre - nombre del estudiante
	 * @param dni - su dni
	 * @param tasas - sus tasas
	 * @param beca - su beca
	 * @param tituloPostgrado - su titulo de postgrado
	 * @param programa - su programa de doctorado
	 */
	public EDoctorado(String nombre, String dni, double tasas, double beca, String tituloPostgrado, ProgramaDoctorado programa) {
		super(nombre, dni, Math.min(Math.max(tasas, MINTAX), MAXTAX), beca, tituloPostgrado);
		setPrograma(programa);
	}

	/**
	 * Observador del programa 
	 * @return el programa
	 */
	public ProgramaDoctorado getPrograma() {
		return programa;
	}

	/**
	 * Modificador del programa
	 * @param programa - programa asociado al estudiante
	 */
	public void setPrograma(ProgramaDoctorado programa) {
		this.programa = programa;
	}

	/**
	 * La beca de un estudiante de Doctorado es la de su programa más la suya propia por ser estudiante de postgrado 
	 * @return la beca total 
	 */
	@Override
	public double getBeca(){
		return super.getBeca() + programa.getBeca();
	}

	@Override
	public double saldo() {
		// POSITIVO: el saldo como estudiante - su beca total 
		return super.saldo() - this.getBeca();
	}

	@Override
	public String toString() {
		return super.toString() + String.format(" programa:%s", this.getPrograma());
	}

	
}
