YELLOW := \033[1;33m
GREEN := \033[1;32m
CYAN := \033[1;36m
RED := \033[1;31m
RESET := \033[0m

all: up

build:
	@echo "$(YELLOW)Building the docker image...$(RESET)"
	sudo docker compose build

run:
	@echo "$(GREEN)Starting the docker container...$(RESET)"
	sudo docker compose up --build -d
	@echo "$(GREEN)Container started! Navigate to http://localhost:4200$(RESET)"

down:
	@echo "$(CYAN)Stopping the docker container...$(RESET)"
	sudo docker compose down

clean:
	@echo "$(RED)Stopping the docker container and removing image and volumes...$(RESET)"
	sudo docker compose down -v --rmi all

help:
	@echo "Usage: make [target]"
	@echo ""
	@echo "Targets:"
	@echo "  build   Build the docker image"
	@echo "  run     Start the docker container"
	@echo "  down    Stop the docker container"
	@echo "  clean   Stop the docker container and remove the image"

.PHONY: all build run down clean help
