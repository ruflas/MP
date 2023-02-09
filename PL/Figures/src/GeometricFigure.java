
public abstract class GeometricFigure {
	public abstract double area();
	public abstract double perimeter();
	/**
	* Calcula el �rea total de un array de figuras geom�tricas
	* @param figs array de figuras geom�tricas
	* @return el �rea total de todas las figuras
	*/
	static public double totalArea(GeometricFigure []figs) {
		if(figs == null|| figs.length<0) {
			return 0;
		}
		else {
			double totalArea = 0;
			for(int i = 0; i<figs.length; i++) {
				totalArea += figs[i].area();
			}
			return totalArea;
		}
	}
}
