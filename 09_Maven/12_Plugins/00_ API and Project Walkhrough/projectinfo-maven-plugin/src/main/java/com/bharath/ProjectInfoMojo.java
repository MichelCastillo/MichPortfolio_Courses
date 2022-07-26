package com.bharath;

import java.util.List;

import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

@Mojo(name = "info-renderer", defaultPhase = LifecyclePhase.COMPILE)
public class ProjectInfoMojo extends AbstractMojo {

	@Parameter(defaultValue = "${project}", required = true, readonly = true)
	MavenProject project;

	@Parameter(property = "scope")
	String scope;

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info("Mojos are cool");
		getLog().info("Project Name: " + project.getName() + " Artifact Id: " + project.getArtifactId());
		List<Dependency> dependencies = project.getDependencies();
		dependencies.stream().filter(d -> scope != null && scope.equals(d.getScope()))
				.forEach(d -> getLog().info(d.toString()));
	}

}
