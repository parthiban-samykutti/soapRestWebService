Fixing ‘file’ access is not allowed due to restriction set by the accessExternalSchema property in Java 8.

Please create a file named ‘jaxp.properties‘ and paste the below content to it.

javax.xml.accessExternalSchema = all

save the file to your jdk installation directory/jre/lib folder.