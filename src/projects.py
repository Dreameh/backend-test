import os

from flask import Blueprint, jsonify, request

# Local
from .models import Project
from . import db


projects_blueprint = Blueprint('projects', __name__)


@projects_blueprint.route('/projects', methods=['GET'])
def all_books():
    response_object = {
        'status': 'success',
        'container_id': os.uname()[1],
        'projects': [project.to_json() for project in Project.query.all()]}

    return jsonify(response_object)


@projects_blueprint.route('/projects/ping', methods=['GET'])
def ping():
    return jsonify({
        'status': 'success',
        'message': 'pong!',
        'container_id': os.uname()[1]
    })


if __name__ == '__main__':
    app.run()
