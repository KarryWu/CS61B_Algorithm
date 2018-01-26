public class NBody {

    public static double readRadius(String filename) {
        In in = new In(filename);
        in.readDouble();
        return in.readDouble();
    }

    public  static Planet[] readPlanets(String filename){
        In in = new In(filename);
        int num = in.readInt();
        in.readDouble();
        Planet[] planets = new Planet[num];
        for(int i = 0; i<num; i++) {
         planets[i] = new Planet(in.readDouble(),in.readDouble(), in.readDouble(),
                 in.readDouble(), in.readDouble(), in.readString());

        }
        return planets;
    }

    public  static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planets = readPlanets(filename);
        double  radius = readRadius(filename);
        StdDraw.setXscale(-radius, radius);
        StdDraw.setYscale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0,0,"./images/starfield.jpg");
        for (int i = 0; i < planets.length; i++){
            planets[i].draw();
        }
        for (double time = 0; time < T; time += dt){
            double[] xForces  = new double[planets.length];
            double[] yForces  = new double[planets.length];
            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0,0,"./images/starfield.jpg");
            for (int i = 0; i < planets.length; i++){
                planets[i].draw();
            }
        StdDraw.show(10);
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel, planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}