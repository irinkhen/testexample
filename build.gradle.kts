
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.3.0-SNAPSHOT"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.23"
	kotlin("plugin.spring") version "1.9.23"
}

group = "test.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	compileOnly("org.projectlombok:lombok:1.18.32")

	testImplementation("com.codeborne:selenide:7.3.1")
	implementation("com.codeborne:selenide:7.3.1")
	//testImplementation("org.testng:testng:7.10.2")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.0-M1")

	runtimeOnly("org.postgresql:postgresql")
	implementation("org.postgresql:postgresql:42.7.3")
	implementation("org.jdbi:jdbi3:3.0.0-beta2")
	implementation("org.jdbi:jdbi3-sqlobject:3.45.1")

	testImplementation("io.qameta.allure:allure-selenide:2.18.1")
	implementation("io.qameta.allure:allure-selenide:2.18.1")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "21"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

