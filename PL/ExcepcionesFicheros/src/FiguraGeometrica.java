import java.io.Serializable;

public abstract class FiguraGeometrica implements Serializable {
	
	public abstract double  perimetro();
	public abstract double area();
	/**
	* Calcula el �rea total de un array de figuras geom�tricas
	* @param figs array de figuras geom�tricas
	* @return el �rea total de todas las figuras
	*/
	static public double areaTotal(FiguraGeometrica[] figs) {
		double areaTotal = 0;
		for (FiguraGeometrica f: figs)
			areaTotal += f.area();
		return areaTotal;
	}
}
