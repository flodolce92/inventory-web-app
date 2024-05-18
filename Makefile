YELLOW := \033[1;33m
GREEN := \033[1;32m
CYAN := \033[1;36m
RED := \033[1;31m
RESET := \033[0m

all: up

build:
	@echo "$(YELLOW)Building the docker image...$(RESET)"
	docker compose build

up: build
	@echo "$(GREEN)Starting the docker container...$(RESET)"
	docker compose up -d
	@echo "$(GREEN)Container started! Navigate to http://localhost:4200$(RESET)"

down:
	@echo "$(CYAN)Stopping the docker container...$(RESET)"
	docker compose down

clean:
	@echo "$(RED)Stopping the docker container and removing the image...$(RESET)"
	docker compose down --rmi all

help:
	@echo "Usage: make [target]"
	@echo ""
	@echo "Targets:"
	@echo "  build   Build the docker image"
	@echo "  up      Start the docker container"
	@echo "  down    Stop the docker container"
	@echo "  clean   Stop the docker container and remove the image"

.PHONY: all build up down clean help
