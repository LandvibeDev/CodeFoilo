FROM centos:centos7
# Install basic packages
ENV JAVA_TOOL_OPTIONS -Dfile.encoding=UTF8
ENV LANG kr_KO.UTF-8
RUN yum install -y epel-release
RUN yum install -y nginx telnet nc tar vim unzip net-tools java-1.8.0-openjdk-devel.x86_64

# Codefolio setup
RUN mkdir -p /codefolio/operation
VOLUME ["/codefolio/operation"]
EXPOSE 80 8080
WORKDIR /codefolio
ADD run.sh /codefolio/run.sh
RUN chmod 755 /codefolio/run.sh
ADD nginx/nginx.conf /etc/nginx/nginx.conf
ADD jar/*.jar /codefolio/

ENTRYPOINT ["/codefolio/run.sh"]
