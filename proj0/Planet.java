public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p) {
		double dx = this.xxPos - p.xxPos;
		double dy = this.yyPos - p.yyPos;
		double distance = Math.sqrt(dx * dx + dy * dy);
		return distance;
	}

	public double calcForceExertedBy(Planet p) {
		double force;
		double G = 6.67 * Math.pow(10,-11);
		force = G * this.mass * p.mass / (this.calcDistance(p) * this.calcDistance(p));
		return force;
	}

	public double calcForceExertedByX(Planet p) {
		double force_x;
		force_x = this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) / this.calcDistance(p);
		return force_x;
	}

	public double calcForceExertedByY(Planet p) {
		double force_y;
		force_y = this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) / this.calcDistance(p);
		return force_y;
	}

 	public double calcNetForceExertedByX(Planet[] Planets) {
 		double force_net_x = 0.0;
 	 	for(int i = 0; i < Planets.length; i++){
 	 		if(this != Planets[i]){
 	 			force_net_x += this.calcForceExertedByX(Planets[i]);
 	 		}
 	 	}
 	 	return force_net_x;
 	}

 	public double calcNetForceExertedByY(Planet[] Planets) {
 		double force_net_y = 0.0;
 	 	for(int i = 0; i < Planets.length; i++){
 	 		if(this != Planets[i]){
 	 			force_net_y += this.calcForceExertedByY(Planets[i]);
 	 		}
 	 	}
 	 	return force_net_y;
 	}

 	public void update(double dt, double fX, double fY) {
 		this.xxVel = this.xxVel + (fX / this.mass) * dt;
 		this.yyVel = this.yyVel + (fY / this.mass) * dt;
 		this.xxPos = this.xxPos + this.xxVel * dt;
 		this.yyPos = this.yyPos + this.yyVel * dt;
 	}

 	public void draw() {
 		String planetImg = "./images/" + this.imgFileName;
 		StdDraw.picture(this.xxPos, this.yyPos, planetImg);
 	}
}

