import java.sql.SQLException;
import java.util.List;

import model.*;


public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		JVDB jvdb = new JVDB();
		List<Movie> movies = jvdb.getMovies();
		for (Movie m : movies)
			System.out.println(m.getName() + ", " + m.getDirectors());
	}

}
